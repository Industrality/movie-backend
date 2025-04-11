package io.git.industrality.moviebackend.configuration;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

// TODO: Why the fudge is this going off 4 times per request?

@Order(value = Ordered.HIGHEST_PRECEDENCE)
@Component
@Slf4j
@WebFilter(filterName = "RequestCachingFilter", urlPatterns = "/*")
public class RequestCachingFilter extends OncePerRequestFilter {

  @Override
  protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response,
      FilterChain filterChain) throws ServletException, IOException {
    CachedHttpServletRequest cachedHttpServletRequest = new CachedHttpServletRequest(request);
    log.info("Request: " + request.getRequestURI());
    log.info("REQUEST DATA: {}",
        IOUtils.toString(cachedHttpServletRequest.getInputStream(), StandardCharsets.UTF_8));
    filterChain.doFilter(cachedHttpServletRequest, response);
  }
}
