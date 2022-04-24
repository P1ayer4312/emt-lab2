import { useState, useEffect } from 'react';
import { useNavigate, useParams, useLocation } from 'react-router-dom';

const AddNewBook = ({ apiUrl }) => {
	let [bookName, setBookName] = useState('');
	let [category, setCategory] = useState('');
	let [bookCount, setBookCount] = useState(0);
	let [authorName, setAuthorName] = useState('');
	let [country, setCountry] = useState('');
	let [continent, setContinent] = useState('');
	let [categories, setCategories] = useState(null);
	const navigate = useNavigate();
	const location = useLocation();
	const params = useParams();
	const isAddNewBookRoute = location.pathname === '/addNewBook';
	const submitFunc = (e) => {
		e.preventDefault();
		
		let submitUrl;
		if (isAddNewBookRoute) {
			submitUrl = (apiUrl + `/createBook?` +
				`name=${bookName}&category=${category}&` +
				`authorName=${authorName}&countryName=${country}&` +
				`continent=${continent}&availableCopies=${bookCount}`)
				.replaceAll(' ', '%20');
		} else {
			submitUrl = (apiUrl + `/editBook?id=${params.id}&` +
				`name=${bookName}&category=${category}&` +
				`authorName=${authorName}&countryName=${country}&` +
				`continent=${continent}&availableCopies=${bookCount}`)
				.replaceAll(' ', '%20');
		}
		
		fetch(submitUrl, {
			method: 'POST'
		})
		.then(_ => {
			navigate('../');
		})
		.catch(console.log);
	}

	useEffect(() => {
		fetch(apiUrl + '/getCategories')
			.then(res => res.json())
			.then(data => {
				setCategories(data);
				setCategory(data[0]);
			});
		
		if (!isAddNewBookRoute) {
			fetch(apiUrl + `/getBookById/${params.id}`)
				.then(res => res.json())
				.then(data => {
					const author = data.author;
					setBookName(data.name);
					setCategory(data.category);
					setBookCount(data.availableCopies);
					setAuthorName(author.name);
					setCountry(author.country.name);
					setContinent(author.country.continent);
				})
				.catch(_ => {
					navigate('/');
				});
		}
	}, [isAddNewBookRoute, apiUrl, params.id, navigate]);

		
	return (
		<div style={{
			marginLeft: '20px'
		}}>
			<h1>
				{isAddNewBookRoute ? 'Create new book:' : 'Edit book information:'}
			</h1>
			<form onSubmit={submitFunc}>
				<table>
					<tbody>
						<tr>
							<td>Book name:</td>
							<td>
								<input type="text" value={bookName} onChange={(e) => setBookName(e.target.value)}/>
							</td>
						</tr>
						<tr>
							<td>Category:</td>
							<td>
								<select value={category} onChange={(e) => setCategory(e.target.value)}>
									{categories && categories.map((el, index) => {
										return (
											<option key={index}>{el}</option>
										);
									})}
								</select>
							</td>
						</tr>
						<tr>
							<td>Item count:</td>
							<td>
								<input value={bookCount} type="number" onChange={(e) => setBookCount(e.target.value)}/>
							</td>
						</tr>
						<tr>
							<td>Author name:</td>
							<td>
								<input value={authorName} type="text" onChange={(e) => setAuthorName(e.target.value)}/>
							</td>
						</tr>
						<tr>
							<td>Author's country name:</td>
							<td>
								<input value={country} type="text" onChange={(e) => setCountry(e.target.value)}/>
							</td>
						</tr>
						<tr>
							<td>Continent:</td>
							<td>
								<input value={continent} type="text" onChange={(e) => setContinent(e.target.value)}/>
							</td>
						</tr>
					</tbody>
				</table>
				<button>
					{isAddNewBookRoute ? 'Create book' : 'Update book'}
				</button>
			</form>
			<br />
			<button onClick={() => navigate('../')}>Go back</button>
		</div>
	);
}
 
export default AddNewBook;