<ul class="nav">
  <li>
    <a href="index.php">
      <i class="tim-icons icon-book-bookmark"></i>
      <p>Accueil</p>
    </a>
  </li>
  <li <?if($page=="dash") echo "class=\"active\"";?>>
    <a href="?page=dash">
      <i class="tim-icons icon-chart-pie-36"></i>
      <p>Dashboard</p>
    </a>
  </li>
  <li <?if($page=="notifications") echo "class=\"active\"";?>>
    <a href="?page=notifications">
      <i class="tim-icons icon-bell-55"></i>
      <p>Notifications</p>
    </a>
  </li>
  <li <?if($page=="user") echo "class=\"active\"";?>>
    <a href="?page=user">
      <i class="tim-icons icon-single-02"></i>
      <p>User Profile</p>
    </a>
  </li>
  <li <?if($page=="geolocalisation") echo "class=\"active\"";?>>
    <a href="?page=geolocalisation">
      <i class="tim-icons icon-world"></i>
      <p>G&eacute;olocalisation</p>
    </a>
  </li>
</ul>
