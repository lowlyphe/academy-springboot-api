import { render } from 'preact';
import './style.css';
import Navbar from './components/navbar';

export function App() {
	return (
		<Navbar />
	);
}

function Resource(props) {
	return (
		<a href={props.href} target="_blank" class="resource">
			<h2>{props.title}</h2>
			<p>{props.description}</p>
		</a>
	);
}

render(<App />, document.getElementById('app'));
