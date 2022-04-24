import { useNavigate } from 'react-router-dom';

const AddBookButton = () => {
	const navigate = useNavigate();
	return ( 
		<>
			<br />
			<button onClick={() => navigate('/addNewBook')} style={{position: 'absolute', left: '30px'}} >
				Add new book
			</button>
		</>
	);
}
 
export default AddBookButton;