<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Employe form</title>
</head>
<body>
    <h1>Formulaire Employe multi-arguments</h1>
    <form action="${pageContext.request.contextPath}/employe/save" method="post">
        <p>
            <input type="number" name="emp.id" placeholder="ID">
        </p>
        <p>
            <input type="text" name="emp.nom" placeholder="Nom">
        </p>
        <p>
            <input type="text" name="emp.poste" placeholder="Poste">
        </p>
        <p>
            <input type="number" name="dept.id" placeholder="Departement ID">
        </p>
        <p>
            <input type="text" name="dept.nom" placeholder="Departement Nom">
        </p>

        <input type="submit" value="Envoyer">
    </form>
    <h1>Formulaire Employe avec attribut departement</h1>
    <form action="${pageContext.request.contextPath}/employe/save" method="post">
        <p>
            <input type="number" name="emp.id" placeholder="ID">
        </p>
        <p>
            <input type="text" name="emp.nom" placeholder="Nom">
        </p>
        <p>
            <input type="text" name="emp.poste" placeholder="Poste">
        </p>
        <p>
            <input type="number" name="emp.dept.id" placeholder="Departement ID">
        </p>
        <p>
            <input type="text" name="emp.dept.nom" placeholder="Departement Nom">
        </p>

        <input type="submit" value="Envoyer">
    </form>
</body>
</html>