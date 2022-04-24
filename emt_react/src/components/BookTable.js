import { useState, useEffect } from 'react';
import BookTableRow from './BookTableRow';
import { v4 as uuidv4 } from 'uuid';

const BookTable = ({apiUrl}) => {

	const [books, setBooks] = useState(null);
	
	const deleteBook = (id) => {
		fetch(apiUrl + `/removeBookById/${id}`, {
			method: 'POST'
		})
		.then(_ => {
			setBooks(
				books.filter(book => id !== book.id)
			);
		})
		.catch(console.log);
	}

	const markAsTaken = (id) => {
		fetch(apiUrl + `/markAsTaken/${id}`, {
			method: 'PUT'
		})
		.then(_ => {
			let tempBooks = [...books];
			let bookIndex = tempBooks.findIndex(book => id === book.id);
			tempBooks[bookIndex].availableCopies--;
			setBooks(tempBooks);
		})
		.catch(console.log);
	}

	useEffect(() => {
		fetch(apiUrl + '/getAllBooks')
			.then(res => res.json())
			.then(data => {
				setBooks(data);
			});
	}, [apiUrl]);

	return ( 
		<table className={'booksTable'}>
			<thead>
				<tr className={'bookTableHead'}>
					<th>Book name</th>
					<th>Category</th>
					<th>Author</th>
					<th>Author origins</th>
					<th>Available Copies</th>
					<th style={{border: 'none'}}></th>
				</tr>
			</thead>
			<tbody>
				{books && books.map((book, index) => {
					return (
						<BookTableRow key={uuidv4()} 
							book={book} 
							deleteBook={deleteBook}
							markAsTaken={markAsTaken}
						/>
					);
				})}
			</tbody>
		</table>
	);
}
 
export default BookTable;