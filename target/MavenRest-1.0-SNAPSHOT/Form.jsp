<%-- 
    Document   : Form
    Created on : 17 abr 2024, 22:35:54
    Author     : lluanllo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="https://cdn.tailwindcss.com"></script>
    </head>
    <body>
        <div class="container mx-auto my-10">
            <h2 class="text-2xl font-bold mb-4">Formulario de Registro</h2>
            <form action="Conexion" method="POST" class="space-y-4">
                <div>
                    <label for="correo" class="block">Correo:</label>
                    <input type="email" id="correo" name="correo" class="border border-gray-300 rounded px-4 py-2 w-full" required>
                </div>
                <div>
                    <label for="ciudad" class="block">Ciudad:</label>
                    <input type="text" id="ciudad" name="ciudad" class="border border-gray-300 rounded px-4 py-2 w-full" required>
                </div>
                <div>
                    <label for="fecha_alta" class="block">Fecha de Alta:</label>
                    <input type="date" id="fecha_alta" name="fecha_alta" class="border border-gray-300 rounded px-4 py-2 w-full" required>
                </div>
                <div>
                    <label for="unidades" class="block">Unidades:</label>
                    <input type="number" id="unidades" name="unidades" class="border border-gray-300 rounded px-4 py-2 w-full" required>
                </div>
                <button type="submit" class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded">Enviar</button>
            </form>
        </div>
    </body>
</html>
