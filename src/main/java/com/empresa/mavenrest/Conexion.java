package com.empresa.mavenrest;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Conexion extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Conexion</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Conexion at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Recuperar los datos del formulario
        String correo = request.getParameter("correo");
        String ciudad = request.getParameter("ciudad");
        String fechaAlta = request.getParameter("fecha_alta");
        int unidades = Integer.parseInt(request.getParameter("unidades"));
        
        // Construir el JSON de los datos
        String jsonInputString = "{\"correo\": \"" + correo + "\", \"ciudad\": \"" + ciudad + "\", \"fechaAlta\": \"" + fechaAlta + "\", \"unidades\": " + unidades + "}";
        
        // Realizar la solicitud HTTP POST
        URL url = new URL("http://localhost:8081/api/contact/save");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");
        con.setDoOutput(true);
        
        try {
    // Obtener el flujo de salida de la conexión
            OutputStream os = con.getOutputStream();

            // Escribir los datos en el flujo de salida
            byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);

            // Limpiar y cerrar el flujo de salida
            os.flush();
            os.close();
        } 
        catch (IOException e) {
            // Manejar cualquier excepción de E/S
            e.printStackTrace();
        }

        int responseCode = con.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK || responseCode == HttpURLConnection.HTTP_CREATED) {
            // La solicitud fue exitosa
            // Puedes realizar acciones adicionales si lo deseas
            System.out.println("Código de respuesta del servidor: " + responseCode);

            response.sendRedirect("exito.jsp"); // Redirigir a una página de éxito
        } else {
            // La solicitud falló
            // Puedes manejar el error de alguna manera
            System.out.println("Código de respuesta del servidor fallido: " + responseCode);

            response.sendRedirect("error.jsp"); // Redirigir a una página de error
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
