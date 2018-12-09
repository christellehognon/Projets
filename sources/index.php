<!DOCTYPE html>
<html lang="fr">
  <head>
    <meta charset="utf-8">
    <title>Cockpit Num&eacute;rique</title>
    <link href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,600,700,800" rel="stylesheet" />
    <link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">
    <link rel="stylesheet" href="mini-css.php">
    <script type="text/javascript" src="mini-javascript.php"></script>
  </head>
  <body class="is-preloadk">
    <div id="wrapper">

        <?
          $page = $_POST["page"];
          if($page == "") $page = $_GET["page"];
          if($page == "") $page = "accueil";
          if(file_exists("$page.php") == false) $page = "404";
          include("$page.php");
          include("footer.php");
        ?>
    </div>
  </body>
</html>
