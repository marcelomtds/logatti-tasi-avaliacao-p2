package br.edu.logatti.avaliacao2.exception;

public class ResourceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -2971418745220650952L;

    public ResourceNotFoundException(final String message) {
        super(String.format("O recurso '%s' não foi encontrado.", message));
    }
}