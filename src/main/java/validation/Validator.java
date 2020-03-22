package validation;

public interface Validator<E> {
    /**
     * valideaza o entitate
     * @param entity - entitatea pe care o valideaza
     * @throws ValidationException daca entitatea nu e valida
     */
    int validate(E entity) throws ValidationException;
}