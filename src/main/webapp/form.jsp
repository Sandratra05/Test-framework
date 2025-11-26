<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h1>Formulaire de Methode Get</h1>
    <form action="${pageContext.request.contextPath}/etudiant/save" method="get">
        <input type="text" name="nom" placeholder="Nom">
        <input type="number" name="id" placeholder="ID">
        <input type="submit" value="Envoyer">
    </form>
    
    <h1>Formulaire de Methode Post</h1>
    <form action="${pageContext.request.contextPath}/etudiant/save" method="post">
        <input type="text" name="nom" placeholder="Nom">
        <input type="number" name="id" placeholder="ID">
        <input type="submit" value="Envoyer">
    </form>
</body>
</html>