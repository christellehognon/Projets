
    <div id="fond">
        <img class="lama-etape11" src="images/Lama.png" alt="image de lama" id="Lama">
        <img class="JC" src="images/JCMEX.png" alt="Jean-Claude Vandamme Mexicain">
        <img class="etoile" src="images/etoile.png" alt=""></div>
    <div id="quote">
        <h2>404</h2>
        <p>
          <?
          $cita = file("citations.txt",FILE_IGNORE_NEW_LINES);
          $n = rand(0,count($cita));
          echo $cita[$n];
          ?>
          <br>JC VanDamme
        </p>
        <a href="index.php">Retour !!!</a>
    </div>
