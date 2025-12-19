<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <div>
        <form action="${pageContext.request.contextPath}/upload" method="post" enctype="multipart/form-data">
            <label for="file">Fichier</label>
            <input type="file" name="file" />
            <input type="submit" value="Upload File" />
        </form>
    </div>
    <div>
        <form action="${pageContext.request.contextPath}/uploadMultiple" method="post" enctype="multipart/form-data">
            <label for="files">Fichiers</label>
            <input type="file" name="files" multiple />
            <input type="submit" value="Upload Multiple Files" />
        </form>
    </div>
</body>
</html>