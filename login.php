<?php

	
	 if($_SERVER['REQUEST_METHOD'] == 'POST'){

		$email = $_POST['email'];
		$password  = $_POST['password'];
		
		// $email = "ahmed@ahmed.com";
		// $password  = "1234";



		require_once 'connect.php';

		$sql = "select * from users2 where email = '$email' ";

		$response = mysqli_query($conn, $sql);

		$result = array();
		$result['login'] = array();

		if(mysqli_num_rows($response) === 1){

			$row = mysqli_fetch_assoc($response);

			if(password_verify($password, $row['password'])){

				$index['name']  = $row['name'];
				$index['email'] = $row['email'];
				$index['id']    = $row['id'];

				

				array_push($result['login'], $index);

				$result['success'] = "1";
				$result['message'] = "Success";
				echo json_encode($result);

				mysqli_close($conn);
			}else{
				$result['success'] = "0";
				$result['message'] = "Failure";
				echo json_encode($result);
				
				mysqli_close($conn);
			}
		}



	  }




 ?>