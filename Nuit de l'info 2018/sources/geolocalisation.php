<div class="sidebar">
  <!--
    Tip 1: You can change the color of the sidebar using: data-color="blue | green | orange | red"
-->
  <div class="sidebar-wrapper">
    <div class="logo">
      <a href="javascript:void(0)" class="simple-text logo-normal">
        Stéphane Lévin
      </a>
    </div>
<?include("menu-rose.php");?>

  </div>
</div>
<div class="main-panel">
  <!-- Navbar -->
  <nav class="navbar navbar-expand-lg navbar-absolute navbar-transparent">
    <div class="container-fluid">
      <div class="navbar-wrapper">
        <div class="navbar-toggle d-inline">
          <button type="button" class="navbar-toggler">
            <span class="navbar-toggler-bar bar1"></span>
            <span class="navbar-toggler-bar bar2"></span>
            <span class="navbar-toggler-bar bar3"></span>
          </button>
        </div>
      </div>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navigation" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-bar navbar-kebab"></span>
        <span class="navbar-toggler-bar navbar-kebab"></span>
        <span class="navbar-toggler-bar navbar-kebab"></span>
      </button>
      <div class="collapse navbar-collapse" id="navigation">
        <ul class="navbar-nav ml-auto">
          <li class="search-bar input-group">
            <button class="btn btn-link" id="search-button" data-toggle="modal" data-target="#searchModal"><i class="tim-icons icon-zoom-split"></i>
              <span class="d-lg-none d-md-block">Search</span>
            </button>
          </li>
          <li class="dropdown nav-item">
            <a href="javascript:void(0)" class="dropdown-toggle nav-link" data-toggle="dropdown">
              <div class="notification d-none d-lg-block d-xl-block"></div>
              <i class="tim-icons icon-sound-wave"></i>
              <p class="d-lg-none">
                Notifications
              </p>
            </a>
            <ul class="dropdown-menu dropdown-menu-right dropdown-navbar">
              <li class="nav-link">
                <a href="javascript:void(0)" class="nav-item dropdown-item">Another notification</a>
              </li>
              <li class="nav-link">
                <a href="javascript:void(0)" class="nav-item dropdown-item">Another one</a>
              </li>
            </ul>
          </li>
          <li class="dropdown nav-item">
            <a href="#" class="dropdown-toggle nav-link" data-toggle="dropdown">
              <div class="photo">
                <img src="../assets/img/anime3.png" alt="Profile Photo">
              </div>
              <b class="caret d-none d-lg-block d-xl-block"></b>
              <p class="d-lg-none">
                Log out
              </p>
            </a>
            <ul class="dropdown-menu dropdown-navbar">
              <li class="nav-link">
                <a href="javascript:void(0)" class="nav-item dropdown-item">Profile</a>
              </li>
              <li class="nav-link">
                <a href="javascript:void(0)" class="nav-item dropdown-item">Settings</a>
              </li>
              <li class="dropdown-divider"></li>
              <li class="nav-link">
                <a href="javascript:void(0)" class="nav-item dropdown-item">Log out</a>
              </li>
            </ul>
          </li>
          <li class="separator d-lg-none"></li>
        </ul>
      </div>
    </div>
  </nav>
  <div class="modal modal-search fade" id="searchModal" tabindex="-1" role="dialog" aria-labelledby="searchModal" aria-hidden="true">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <input type="text" class="form-control" id="inlineFormInputGroup" placeholder="SEARCH">
          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <i class="tim-icons icon-simple-remove"></i>
          </button>
        </div>
      </div>
    </div>
  </div>
  <!-- End Navbar -->
  <div class="content">
    <div class="row">
      <div class="col-md-12">
        <div class="card card-plain">
          <div class="card-header">
            OpenStreetMaps
          </div>
          <div id="map">
                <img src="images/streetmap.png" alt="map OpenStreetMap">
              </div>
        </div>
      </div>
    </div>
  </div>

</div>
</div>
<div class="fixed-plugin">
<div class="dropdown show-dropdown">
  <a href="#" data-toggle="dropdown">
    <i class="fa fa-cog fa-2x"> </i>
  </a>
  <ul class="dropdown-menu">
    <li class="header-title"> Sidebar Background</li>
    <li class="adjustments-line">
      <a href="javascript:void(0)" class="switch-trigger background-color">
        <div class="badge-colors text-center">
          <span class="badge filter badge-primary active" data-color="primary"></span>
          <span class="badge filter badge-info" data-color="blue"></span>
          <span class="badge filter badge-success" data-color="green"></span>
        </div>
        <div class="clearfix"></div>
      </a>
    </li>
    <li class="adjustments-line text-center color-change">
      <span class="color-label">LIGHT MODE</span>
      <span class="badge light-badge mr-2"></span>
      <span class="badge dark-badge ml-2"></span>
      <span class="color-label">DARK MODE</span>
    </li>
    <li class="button-container">
      <a href="https://www.creative-tim.com/product/black-dashboard" target="_blank" class="btn btn-primary btn-block btn-round">Download Now</a>
      <a href="https://demos.creative-tim.com/black-dashboard/docs/1.0/getting-started/introduction.html" target="_blank" class="btn btn-default btn-block btn-round">
        Documentation
      </a>
    </li>
    <li class="header-title">Thank you for 95 shares!</li>
    <li class="button-container text-center">
      <button id="twitter" class="btn btn-round btn-info"><i class="fab fa-twitter"></i> &middot; 45</button>
      <button id="facebook" class="btn btn-round btn-info"><i class="fab fa-facebook-f"></i> &middot; 50</button>
      <br>
      <br>
      <a class="github-button" href="https://github.com/creativetimofficial/black-dashboard" data-icon="octicon-star" data-size="large" data-show-count="true" aria-label="Star ntkme/github-buttons on GitHub">Star</a>
    </li>
  </ul>
</div>
</div>
<!--   Core JS Files   -->
<script src="js/jquery.min.js"></script>
<script src="js/popper.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/perfect-scrollbar.jquery.min.js"></script>
<!--  Google Maps Plugin    -->
<!-- Place this tag in your head or just before your close body tag. -->
<script src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY_HERE"></script>
<!-- Chart JS -->
<script src="js/chartjs.min.js"></script>
<!--  Notifications Plugin    -->
<script src="js/bootstrap-notify.js"></script>
<!-- Control Center for Black Dashboard: parallax effects, scripts for the example pages etc -->
<script src="js/black-dashboard.min.js?v=1.0.0"></script>
<!-- Black Dashboard DEMO methods, don't include it in your project! -->
<script src="js/demo.js"></script>

<script src="https://unpkg.com/leaflet@1.3.1/dist/leaflet.js" integrity="sha512-/Nsx9X4HebavoBvEBuyp3I7od5tA0UzAxs+j83KgC8PU0kgB4XiK4Lfe4y4cgBtaRJQEIFCW+oC506aPT2L1zw=="
       crossorigin=""></script>
<script type="text/javascript">
// On initialise la latitude et la longitude de Paris (centre de la carte)
var lat = -24.751163662;
var lon = 15.27249891;
var macarte = null;
// Fonction d'initialisation de la carte
//function initMap() {
// Créer l'objet "macarte" et l'insèrer dans l'élément HTML qui a l'ID "map"
//       macarte = L.map('map').setView([lat, lon], 11);
       // Leaflet ne récupère pas les cartes (tiles) sur un serveur par défaut. Nous devons lui préciser où nous souhaitons les récupérer. Ici, openstreetmap.fr
//       L.tileLayer('https://{s}.tile.openstreetmap.fr/osmfr/{z}/{x}/{y}.png', {
           // Il est toujours bien de laisser le lien vers la source des données
//           attribution: 'données © <a href="//osm.org/copyright">OpenStreetMap</a>/ODbL - rendu <a href="//openstreetmap.fr">OSM France</a>',
//           minZoom: 1,
//           maxZoom: 8
//       }).addTo(macarte);
//   }
//window.onload = function(){
// Fonction d'initialisation qui s'exécute lorsque le DOM est chargé
//initMap();
//};
</script>
<style type="text/css">
#map{ /* la carte DOIT avoir une hauteur sinon elle n'apparaît pas */
height:400px;
}
</style>
