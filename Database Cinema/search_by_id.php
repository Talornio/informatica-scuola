<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ricerca Films</title>
    <style>
      .div3{
        text-align: center;
        width: 95%;
        margin: 0%;
        padding: 15px;
      }
    </style>
</head>
<body>
  <div class="div3">
    <?php
        $hostname = "localhost";
        $username = "a_utente05";
        $password = "a_utente05";
        $database = "a_CINEMA_utente05";
    
        $conn = mysqli_connect($hostname, $username, $password, $database);
        if(!$conn){
            die("Errore durante la connessione: ". mysqli_connect_error());
        }
        
        $db1 = mysqli_select_db($conn, $database);
        if (!$db1){
            die('Accesso al database non riuscito: ' . mysqli_error($conn));
        }
    
        if (isset($_POST["codice"])) {
            $codice = $_POST["codice"];
          } else {
            echo "<h3>mannaggia bro non c'è un errore col post</h3>";
            echo "<br>";
          }
    
        $strSQL = "select attori.nome, film.titolo from attori, film, recita ";
        $strSQL .= "where attori.codAttore = '$codice' and recita.codAttore = attori.codAttore ";
        $strSQL .= "and recita.codFilm = film.codFilm";
    
        $row = mysqli_query($conn, $strSQL);
        if ($row){
          if(mysqli_num_rows($row) > 0){
            while($data = mysqli_fetch_assoc($row)){
              echo "<h3>Nome attore: ";
              echo $data["nome"]; // stampa il valore della colonna nome
              echo "</h3>";
              echo "<h4>Nome film: ";
              echo $data["titolo"]; // stampa il valore della colonna titolo
              echo "</h4>";
            }
          } else {
            echo "<h1>0 results</h1>";
          }
        }
        else{
          echo "Errore nell'inserimento: " . mysqli_error($conn);
        }
    
        mysqli_close($conn);
    ?>
  </div>
    <form action="form.html" method="POST">
      <div class="div3">
        <input type="submit" value="Return">
      </div>
</body>
</html>