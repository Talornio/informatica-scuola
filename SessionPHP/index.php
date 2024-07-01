<?php
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

    $strSQL = "SELECT * FROM attori";
    $result = mysqli_query($db_conn, $strSQL);

    echo'<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Tabella Dati</title>
<style>
  body {
    font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
    background-color: #f4f4f4;
    margin: 0;
    padding: 20px;
  }
  h2 {
    color: #333;
    text-align: center;
  }
  table {
    width: 100%;
    border-collapse: collapse;
    margin-top: 20px;
    margin-left: auto;
    margin-right: auto;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    text-align: center;
    max-width: 700px;
  }
  th, td {
    padding: 12px 15px;
    text-align: left;
    border-bottom: 1px solid #ddd;
  }
  th {
    background-color: #009879;
    color: #ffffff;
    font-weight: bold;
  }
  tr:nth-child(even) {
    background-color: #f2f2f2;
  }
  .links {
    margin-top: 20px;
    text-align: center;
  }
  a {
    display: inline-block;
    text-decoration: none;
    text-align: center;
    color: #009879;
    border: 1px solid #009879;
    padding: 8px 16px;
    border-radius: 5px;
    transition: background-color 0.3s, color 0.3s;
    width: 250px;
    margin-bottom: 10px;
  }
  a:hover {
    background-color: #009879;
    color: #ffffff;
  }
</style>
</head>';
    echo "<body> <h2>Attori disponibili:</h2>";
    echo "<table>";
    echo "<tr><td>Matricola</td><td>Nome</td><td>Data di nascita</td><td>Nazionalità</td></tr>";

    if(mysqli_num_rows($result) > 0){
        while($row = mysqli_fetch_assoc($result)){
            echo "<tr><td>" . $row["codAttore"] . "</td><td>" . $row["nome"] . "</td><td>" . $row["annoNascita"] . "</td><td>" . $row["nazionalita"] . "</td></tr>";
        }

    }

    echo "</table>";
    echo "<br>";
    echo '<div class="links"><a href = ./login.html>Effettua il login come attore!</a> <a href = ./registra_attore.html>Aggiungine un attore!</a></div></body>';
?>