package com.kingdom.manager.models;

public record AddressTypes(
        Integer id,
        String title,
        String description
) {
    /* TODO : validar quando selecionado mais de um tipo de endereço, exp: quando residêncial não pode legal ao mesmo
    *         tempo
    *
    * RESIDENTIAL : O endereço onde uma pessoa mora.
    *       LEGAL : Endereço utilizado para fins fiscais e legais ou endereço registrado legalmente para uma entidade.
    *               Pode ser o endereço da sede de uma empresa.
    *      SOCIAL : Em algumas culturas, pode-se considerar endereços associados a círculos sociais específicos, como
    *               endereços de clubes, associações ou locais de reunião.
    *      POSTAL : O endereço utilizado para envio de correspondência. Pode ser o endereço residencial ou comercial.
    *   TEMPORARY : Um endereço utilizado por um período limitado de tempo, como um endereço de correspondência
    *               temporária enquanto uma pessoa está em transição.
    * */
}
