<?
/* Fichier: javascript-mini.php */
/* Auteur: HPep */

if(!function_exists("scandir"))
{
	function scandir($dir)
	{
		$re = array();
		if ($dh = opendir($dir))
		{
			while (($file = readdir($dh)) !== false)
			{
				$re[] = $file;
			}
			closedir($dh);
		}
		return $re;
	}
}
/* variables */
$data = "";

/* javascript */
foreach(scandir("js") as $f)
{
	if(strtolower(substr("js/$f",-3)) == ".js"){$data .= file_get_contents("js/$f");}
}

/* affichage */
header("Content-type: text/javascript; charset=utf-8");
header("Cache-Control: must-revalidate");
$offset = 60 * 60 * 24 * 7;
$ExpStr = "Expires: " . gmdate("D, d M Y H:i:s", time() + $offset) . " GMT";
header($ExpStr);
ob_start("ob_gzhandler");
print $data;
ob_end_flush();
exit();
?>
