import { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
const ShowCategories = ({ apiUrl }) => {
	const navigate = useNavigate();
	let [categories, setCategories] = useState(null);
	useEffect(() => {
		fetch(apiUrl + '/getCategories')
			.then(res => res.json())
			.then(data => setCategories(data));

	}, [apiUrl]);

	return (
		<div style={{
			marginLeft: '30px'
		}}>
			<h1>Avaliable categories:</h1>
			<ul>
				{categories && categories.map((el, index) => {
					return (
						<li key={index}>{el}</li>
					);
				})}
			</ul>
			<br />
			<button onClick={_ => navigate('../')}>Go back</button>
		</div>
	);
}
 
export default ShowCategories;