<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head><title>Chuyển đổi nhiệt độ</title></head>
<body>
    <h2>Chuyển đổi nhiệt độ</h2>
    <form method="post" action="convert">
        Nhiệt độ: <input type="text" name="temp" value="${param.temp}" /><br/>
        Loại chuyển đổi:
        <select name="type">
            <option value="CtoF">Celsius → Fahrenheit</option>
            <option value="FtoC">Fahrenheit → Celsius</option>
        </select><br/>
        <input type="submit" value="Chuyển đổi" />
    </form>

    <c:if test="${not empty result}">
        <p>Kết quả: <c:out value="${result}" /></p>
    </c:if>

    <c:if test="${not empty error}">
        <p style="color:red;"><c:out value="${error}" /></p>
    </c:if>
</body>
</html>
