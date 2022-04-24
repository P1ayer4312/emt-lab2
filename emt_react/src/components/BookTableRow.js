import { v4 as uuidv4 } from 'uuid';
import { useNavigate } from 'react-router-dom';

const BookTableRow = ({ book, deleteBook, markAsTaken }) => {
	const navigate = useNavigate();
	return (
		<tr className={'bookTableBody'}>
			<td key={uuidv4()}>{book.name}</td>
			<td key={uuidv4()}>{book.category}</td>
			<td key={uuidv4()}>{book.author.name}</td>
			<td key={uuidv4()}>{`${book.author.country.continent}, ${book.author.country.name}`}</td>
			<td key={uuidv4()}>{book.availableCopies}</td>
			<td>
				<button onClick={_ => navigate(`/editBook/${book.id}`)}>Edit</button>
				<button onClick={_ => deleteBook(book.id)}>Delete</button>
				<button onClick={_ => markAsTaken(book.id)}>Mark as taken</button>
			</td>
		</tr>
	);
}

export default BookTableRow;