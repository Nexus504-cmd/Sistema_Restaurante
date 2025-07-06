/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConexionPGadmin;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

/**
 *
 * @author Arana
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

public class Api_Dni {

    private final String token = "apis-token-16738.vOm6I03uZLfyzI56oRZY6lCd7SASIg5V";
    private final String baseUrl = "https://api.apis.net.pe/v2/reniec/dni?numero=";

    public HttpURLConnection crearConexion(String dni) {
        HttpURLConnection con = null;
        try {
            String apiUrl = baseUrl + dni;
            URL url = new URL(apiUrl);
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Authorization", "Bearer " + token);
            con.setRequestProperty("Content-Type", "application/json");
        } catch (Exception e) {
            System.out.println("Mensaje Error: " + e.getMessage());
        }
        return con;
    }

    public StringBuilder lecturaderespuesta(HttpURLConnection con) {
        StringBuilder respuesta = new StringBuilder();
        try {
            int status = con.getResponseCode();
            if (status == 200) {
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    respuesta.append(inputLine);
                }
                in.close();
            } else {
                System.out.println("Error HTTP: " + status);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (con != null) {
                con.disconnect();
            }
        }
        return respuesta;
    }

    public String obtenerNombre(StringBuilder respuesta) {
        try {
            JSONObject obj = new JSONObject(respuesta.toString());
            return obj.getString("nombres");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return "";
        }
    }

    public String obtenerApellidoPaterno(StringBuilder respuesta) {
        try {
            JSONObject obj = new JSONObject(respuesta.toString());
            return obj.getString("apellidoPaterno");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return "";
        }
    }

    public String obtenerApellidoMaterno(StringBuilder respuesta) {
        try {
            JSONObject obj = new JSONObject(respuesta.toString());
            return obj.getString("apellidoMaterno");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return "";
        }
    }
}
