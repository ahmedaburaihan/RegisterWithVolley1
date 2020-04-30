<?php 

	if($_SERVER['REQUEST_METHOD'] == 'POST'){

		$id = $_POST['id'];

	
		require_once 'connect.php';

		$sql = "select * from users2 where id= '$id' ";
		$response = mysqli_query($conn, $sql);

		$result = array();
		$result['read'] = array();

		if(mysqli_num_rows($response) === 1){
			if($row = mysqli_fetch_assoc($response)){
				$h['name'] = $row['name'];
				$h['email']= $row['email'];

				array_push($result['read'], $h);

				$result['success'] = "1";
				echo json_encode($result);
			}
		}

	} else{
		$result['success'] = "0";
		$result['message'] = "Error!";
		echo json_encode($result);
		mysqli_close($conn);
	}



?>