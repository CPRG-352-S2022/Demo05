<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Average Calculator</title>
    </head>
    <body>
        <h1>Average Calculator</h1>
        <form method="get" action="average">
            <label>Enter a number:</label>
            <input type="number" name="number" value="">
            <br>
            <input type="submit" value="Calculate Average">
        </form>
        <p>Average: ${average}</p>
        <form method="get" action="average">
            <input type="submit" value="Reset">
            <input type="hidden" name="operation" value="reset">
        </form>
    </body>
</html>
