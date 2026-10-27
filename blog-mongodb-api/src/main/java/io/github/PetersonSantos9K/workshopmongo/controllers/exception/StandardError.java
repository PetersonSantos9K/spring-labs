package io.github.PetersonSantos9K.workshopmongo.controllers.exception;

public record StandardError(Long timestamp, Integer status, String error, String exception, String path){
}
