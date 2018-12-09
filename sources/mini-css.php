<?
/* Fichier: mini-css.php */
/* Auteur: HPep */

if(!function_exists("scandir"))
{
	function scandir($dir)
	{
		$dh = opendir($dir);
		while (false !== ($filename = readdir($dh)))
		{
			if ($filename != '.' && $filename != '..')
			{
				$re[] = $filename;
			}
		}
		closedir($dh);
		return $re;
	}
}
/* variables */
$data = "";

/* fichiers css */
foreach(scandir("css/") as $f)
{
	if(strtolower(substr("css/$f",-3)) == "css")
	{
		$data .= file_get_contents("css/$f");
	}
}

/* affichage */
header("Content-type: text/css; charset=utf-8");
header("Cache-Control: must-revalidate");
$offset = 60 * 60 * 24 * 7;
$ExpStr = "Expires: " . gmdate("D, d M Y H:i:s", time() + $offset) . " GMT";
header($ExpStr);
ob_start("ob_gzhandler");
print $data;
ob_end_flush();
?>
