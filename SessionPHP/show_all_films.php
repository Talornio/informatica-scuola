<?php
session_start();

$hostname = "localhost";
$username = "utente00";
$password = "";
$database = "cinema";

// Connessione al database
$db_conn = mysqli_connect($hostname, $username, $password, $database);
$codAttore = $_SESSION['codAttore'];
if(!$db_conn) die("Accesso al database non riuscito: ".mysqli_error($db_conn));

    $strSQL = "SELECT * FROM film";
    $result = mysqli_query($db_conn, $strSQL);

echo "<!DOCTYPE html>
<html lang='it'>
<head>
<meta charset='UTF-8'>
<meta name='viewport' content='width=device-width, initial-scale=1.0'>
<title>Elenco Film Attore</title>
<link href='https://fonts.googleapis.com/css2?family=Segoe+UI:wght@400;700&display=swap' rel='stylesheet'>
<style>
  body {
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    background-color: #f4f4f4;
    margin: 0;
    padding: 20px;
  }
  .container {
    background-color: #fff;
    padding: 20px;
    border-radius: 5px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    max-width: 700px;
    margin: auto;
  }
  h2 {
    color: #333;
    text-align: center;
  }
    .pgselect {
    margin-left: 10%;
    display: inline-block;
    text-decoration: none;
    color: #009879;
    border: 1px solid #009879;
    padding: 8px 16px;
    border-radius: 5px;
    transition: background-color 0.3s, color 0.3s;
  }
  .pgselect:hover {
    background-color: #009879;
    color: #ffffff;
  }
  p {
    font-size: 18px;
    line-height: 1.6;
  }
  .linkatt {
    color: #ffffff;
    text-decoration: none;
    font-weight: bold;
  }
  footer {
    background-color: #009879;
    color: #ffffff;
    padding: 20px;
    text-align: center;
    border-radius: 5px;
    margin-top: 20px;
    max-width: 700px;
    margin-right: auto;
    margin-left: auto;
    
  }
</style>
</head>
<body>

<div class='container'>
  <h2>Tutti i film disponibili</h2>";

if (mysqli_num_rows($result) > 0) {
    while ($row = mysqli_fetch_assoc($result)) {
        echo "<p><strong>Titolo:</strong> " . $row["titolo"] . "</p>
              <p><strong>Anno:</strong> " . $row["annoProduzione"] . "</p>
              <p><strong>Nazionalità:</strong> " . $row["nazionalita"] . "</p>
              <p><strong>Regista:</strong> " . $row["regista"] . "</p>
              <p><strong>Genere:</strong> " . $row["genere"] . "</p><hr>";
    }
} else {
    echo "<p>Nessun film trovato per l'attore selezionato.</p>";
}

echo "<br><br><a class=pgselect href = ./inserisci_film.html>Inserisci un nuovo film per l'attore!</a><a class=pgselect href = ./welcome.php>Visualizza i film dell'attore!</a>";
echo "</div>
<footer>
  <p>Ci sono attori che dovrebbero far parte di film già presenti, ma non lo sono?<br><a class=linkatt href='./collegaAF.html'>Collegali qui!</a></p>
</footer>

</body>
</html>";
?>


<!-- <?php
    //avvia la sessione
    session_start();

    //credenziali accesso
    $hostname = "localhost";
    $username = "utente00";
    $password = "";
    $database = "cinema";

    //connessione al database
    $db_conn = mysqli_connect($hostname, $username, $password, $database);
    
    if(!$db_conn) die("Accesso al database non riuscito: ".mysqli_error($db_conn));

    $strSQL = "SELECT * FROM film";
    $result = mysqli_query($db_conn, $strSQL);

    echo"<style>
    table {
    border-collapse:collapse
    }
    td, th {
    border:1px solid #ddd;
    padding:8px;
    }
    footer{
        position: absolute;
        bottom: 0;
        width: 100%;
        height: 2.5rem;
    }
    </style>";
    echo "<h1>Tutti i film disponibili:</h1>";
    echo "<table>";
    echo "<tr><td>Codice Film</td><td>Titolo</td><td>Data di uscita</td><td>Nazionalità</td><td>Regista</td><td>Genere</td></tr>";

    if(mysqli_num_rows($result) > 0){
        while($row = mysqli_fetch_assoc($result)){
            echo "<tr><td>" . $row["codFilm"] . "</td><td>" . $row["titolo"] . "</td><td>" . $row["annoProduzione"] . "</td>";
            echo"<td>" . $row["nazionalita"] . "</td><td>" . $row["regista"] . "</td><td>" . $row["genere"] . "</td></tr>";
        }

    }

    echo "</table>";
    echo "<br><br><a href = ./inserisci_film.html>Inserisci un nuovo film per l'attore!</a> O <a href = ./welcome.php>visualizza i film dell'attore!</a>";
    echo "<footer>Ci sono attori che dovrebbero far parte di film già presenti, ma non lo sono? <a href = ./collegaAF.html>Collegali qui!</a></footer>";
?> -->