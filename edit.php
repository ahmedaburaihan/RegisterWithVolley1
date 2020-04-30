<?php

	if($_SERVER['REQUEST_METHOD'] == 'POST'){

		$name = $_POST['name'];
		$email = $_POST['email'];
		$id = $_POST['id'];

		require_once 'connect.php';

		$sql = "update users2 set name='$name', email='$email' where id='$id' ";

		if(mysqli_query($conn, $sql)){
			$result['success'] = "1";
			$result['message'] = "success";
			echo json_encode($result);
			mysqli_close($conn);
		}

	}else{
			$result['success'] = "0";
			$result['message'] = "error!";
			json_encode($result);
			mysqli_close($conn);
		}




?>