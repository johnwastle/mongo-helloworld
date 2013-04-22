<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title></title>
</head>
<body>
<h1>
	Mongo 'hello world'
</h1>

<p>
    Insert into mongotest collection on local mongo node.
</p>
<p>
    <a href="/mongo">Using standard mongo library</a>
</p>
<p>
    <a href="/mongoSpring">Using Spring Data mongo abstraction</a>
</p>

<c:if test="${not empty person}">
    <p>Operation complete</p>
    <p>${person} inserted in mongo!</p>
</c:if>

</p>
</body>
</html>
