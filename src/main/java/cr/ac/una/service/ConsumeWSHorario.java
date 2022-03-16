package cr.ac.una.service;/*
 * Copyright (c) 2019.
 *
 * Centro de Gestion Informatica
 * Direccion de Tecnologias de la Informacion y Comunicacion
 * Universidad Nacional - Costa Rica
 * http://www.una.ac.cr
 *
 */

import cr.ac.una.domain.HorarioDTO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import java.text.SimpleDateFormat;
import java.util.*;


public class ConsumeWSHorario {

    private String USER_REST = "djh_rest";
    private String PASS_REST = "psswrd_rest1";



    private HttpHeaders getPrepareHeaders(MediaType contentType, List<MediaType> acceptableMediaTypes) throws Exception {


        HttpHeaders headers = new HttpHeaders();

        byte[] xApiAuthTokenBytes = String.join(":", USER_REST, PASS_REST).getBytes("utf-8");
        String xApiAuthToken = Base64.getEncoder().encodeToString(xApiAuthTokenBytes);

        headers.setContentType(contentType);
        headers.setAccept(acceptableMediaTypes);
        headers.add("Authorization", "Basic " + xApiAuthToken);
        return headers;
    }

    /**
     * Consulta la declaracion jurada del id que se envía por parámetro y la
     * retorna en forma de StreamContent
     *
     * @author Jeffry Jiménez Casares
     * @param idDeclaracionJurada
     * @return
     */


    /**
     * Metodo que obtiene los horarios de un funcionario
     *
     * @param identificacion
     * @param fechaDesde
     * @param fechaHasta
     * @return
     */

    public List<HorarioDTO> findDeclaracionHorariosByPersona(String identificacion, Date fechaDesde, Date fechaHasta) {
        HorarioDTO[] listHorariosDTO;
        List<HorarioDTO> horarios = new ArrayList();

        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/YYYY");
            final String uri = "https://www.mihorario.una.ac.cr/horario/api/horario/getAllByIdentificacionAndFechaInicioAndFechaFin";
            Map<String, Object> data = new HashMap();
            data.put("identificacion", identificacion);
            data.put("fechaInicio", formatoFecha.format(fechaDesde));
            data.put("fechaFin", fechaHasta != null ? formatoFecha.format(fechaHasta) : null);

            MediaType contentType = MediaType.APPLICATION_JSON;
            List<MediaType> acceptableMediaTypes = Arrays.asList(MediaType.APPLICATION_JSON);
            HttpHeaders headers = getPrepareHeaders(contentType, acceptableMediaTypes);
            HttpEntity<Map<String, Object>> entity = new HttpEntity<Map<String, Object>>(data, headers);

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<HorarioDTO[]> responseEntity = restTemplate.exchange(
                    uri,
                    HttpMethod.POST,
                    entity,
                    HorarioDTO[].class);
            listHorariosDTO = (HorarioDTO[]) responseEntity.getBody();
            for (HorarioDTO horarioDTO : listHorariosDTO) {
                if (horarioDTO.getEstado().equals("ACTIVO") || horarioDTO.getEstado().equals("HISTORICO")) {
                    horarios.add(horarioDTO);
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
        return horarios;
    }

    /**
     * Método REST Api que busca una declaracion horario por id
     *
     * @param idHorario
     * @return
     */

    public HorarioDTO findOneDeclaracionHorarioById(String idHorario) {
        HorarioDTO horarioDTO = new HorarioDTO();
        try {
            String uriParametro = "https://www.mihorario.una.ac.cr/horario/api/horario/get/p/";

            RestTemplate restTemplate = new RestTemplate();
            MediaType contentType = MediaType.APPLICATION_JSON;
            List<MediaType> acceptableMediaTypes = Arrays.asList(MediaType.APPLICATION_JSON);
            final String uri = uriParametro + idHorario;

            HttpEntity<String> entity = new HttpEntity<>(getPrepareHeaders(contentType, acceptableMediaTypes));



            ResponseEntity<HorarioDTO> responseEntity = restTemplate.exchange(
                    uri,
                    HttpMethod.GET,
                    entity,
                    HorarioDTO.class);

            horarioDTO = (HorarioDTO) responseEntity.getBody();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return horarioDTO;
    }
}
