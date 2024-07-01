<?php
    $hostname = "localhost";
    $username = "a_utente05";
    $password = "a_utente05";
    $database = "a_officina_utente05";

    $conn = mysqli_connect($hostname, $username, $password, $database);
    if(!$conn){
        die("Errore durante la connessione: ". mysqli_connect_error());
    }

    $db1 = mysqli_select_db($conn, $database);
    if (!$db1){
        die('Accesso al database non riuscito: ' . mysqli_error($conn));
    }

    $cf = $_POST["cf"];
    $indirizzo = $_POST["ind"];
    $nome= $_POST["nome"];
    $cognome = $_POST["cogn"];
    
    $strSQL = "INSERT INTO Proprietario (CodiceFiscale, Indirizzo, Nome, Cognome) ";
    $strSQL .= "VALUES ('$cf', '$indirizzo', '$nome', '$cognome')";
    
    if (mysqli_query($conn, $strSQL)){
      echo "Proprietario aggiunto correttamente";
    }
    else{
      echo "Errore nell'inserimento: " . mysqli_error($conn);
    }
    
    mysqli_close($conn);
?>