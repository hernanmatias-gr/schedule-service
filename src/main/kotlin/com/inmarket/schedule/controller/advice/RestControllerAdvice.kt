package com.inmarket.schedule.controller.advice

import com.inmarket.schedule.constant.ProblemType
import com.inmarket.schedule.dto.problem.Field
import com.inmarket.schedule.dto.problem.FieldProblem
import com.inmarket.schedule.dto.problem.Problem
import com.inmarket.schedule.exception.ResourceNotFoundException
import com.inmarket.schedule.utils.CompanionLogger
import com.inmarket.schedule.utils.camelToSnakeCase
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.validation.FieldError
import org.springframework.web.HttpRequestMethodNotSupportedException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.servlet.NoHandlerFoundException
import java.net.URI
import javax.servlet.http.HttpServletRequest
import javax.validation.ConstraintViolationException

@RestControllerAdvice
class RestControllerAdvice {


    @ExceptionHandler(NoHandlerFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleNoHandlerFoundException(ex: NoHandlerFoundException, request: HttpServletRequest) =
        ExceptionContext(ex = ex, request = request, problemType = ProblemType.HTTP_METHOD_NO_FOUND)
            .toHttpResponse()

    @ExceptionHandler(HttpRequestMethodNotSupportedException::class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    fun handleHttpRequestMethodNotSupportedException(ex: HttpRequestMethodNotSupportedException, request: HttpServletRequest) =
        ExceptionContext(ex = ex, request = request, problemType = ProblemType.HTTP_REQUEST_METHOD_NOT_SUPPORTED)
            .toHttpResponse()

    @ExceptionHandler(ResourceNotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleResourceNotFoundException(ex: ResourceNotFoundException, request: HttpServletRequest) =
        ExceptionContext(ex = ex, request = request, problemType = ProblemType.RESOURCE_NOT_FOUND)
            .toHttpResponse()

    @ExceptionHandler(MethodArgumentNotValidException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleMethodArgumentNotValidException(ex: MethodArgumentNotValidException, request: HttpServletRequest) =
        MethodArgumentNotValidExceptionContext(ex = ex, request = request, problemType = ProblemType.HTTP_BAD_REQUEST)
            .toHttpResponse()

    @ExceptionHandler(Exception::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun handleUncaughtException(ex: Exception, request: HttpServletRequest) =
        ExceptionContext(ex = ex, request = request, problemType = ProblemType.INTERNAL_SERVER_ERROR)
            .toHttpResponse()


    data class ExceptionContext(val ex: Exception, val request: HttpServletRequest, val problemType: ProblemType)

    private fun ExceptionContext.toProblem() =
        Problem(
            type = problemType.type,
            title = problemType.title,
            status = problemType.status,
            detail = ex.message ?: "Exception occurred",
            instance = URI.create(request.requestURI),
        )

    private fun ExceptionContext.toHttpResponse() =
        toProblem()
            .toResponseEntity()
            .log { error("Exception captured", ex) }

    data class MethodArgumentNotValidExceptionContext(val ex: MethodArgumentNotValidException, val request: HttpServletRequest, val problemType: ProblemType)

    private fun MethodArgumentNotValidExceptionContext.toFieldProblem() =
        FieldProblem(
            type = problemType.type,
            title = problemType.title,
            status = problemType.status,
            detail = ex.message,
            instance = URI.create(request.requestURI),
            fields = ex.fieldErrors.map { it.toField() }
        )

    private fun FieldError.toField() =
        Field(
            field = field.camelToSnakeCase(),
            value = rejectedValue ?: "No value provided",
            message = defaultMessage ?: "Field is invalid"
        )

    private fun MethodArgumentNotValidExceptionContext.toHttpResponse() =
        toFieldProblem()
            .toResponseEntity()
            .log { error("Exception captured", ex) }

    private fun Problem.toResponseEntity() =
        ResponseEntity
            .status(status)
            .contentType(MediaType.APPLICATION_PROBLEM_JSON)
            .body(this)

    companion object : CompanionLogger()
}
