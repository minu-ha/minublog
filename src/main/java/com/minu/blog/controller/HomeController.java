package com.minu.blog.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController{

    @GetMapping( "/" )
    public String index(){
        return "index";
    }

    @ApiResponses(
            { @ApiResponse( responseCode = "200", description = "OK !!" )
            , @ApiResponse( responseCode = "400", description = "BAD REQUEST !!" )
            , @ApiResponse( responseCode = "404", description = "NOT FOUND !!" )
            , @ApiResponse( responseCode = "500", description = "INTERNAL SERVER ERROR !!" ) } )
    @Operation( summary = "test hello", description = "hello api example" )
    @GetMapping( "/hello" )
    @ResponseBody
    public ResponseEntity<String> hello(
            @Parameter( description = "이름", required = true, example = "Park" )
            @RequestParam String name ){
        return ResponseEntity.ok( "hello " + name );
    }

}
