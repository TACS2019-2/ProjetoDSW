<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Nova Carona</title>
</head>
<body>
<div align="center">
    <h2>Nova Carona</h2>
    <form:form action="salvar" method="post" modelAttribute="carona">
        <table border="0" cellpadding="5">
            <tr>
                <td>Descri��o: </td>
                <td><form:input path="descricao" required="required"/></td>
            </tr>
            <tr>
                <td>Bairro: </td>
                <td><form:input path="bairro" required="required"/></td>
            </tr>
            <tr>
                <td>Tipo: </td>
                <td><form:select name="TipoCarona" path="tipo" items="${tipos}">
                    </form:select>
                </td>
            </tr>
            <tr>
                <td>Turno: </td>
                <td><form:select name="TipoCarona" path="turno" items="${turnos}">
                </form:select>
                </td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Save"></td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>
