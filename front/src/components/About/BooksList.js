import React from "react";
import Loader from "react-loaders";

class BooksList extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            items: [],
            dataIsLoaded: false
        };
    }

    componentDidMount() {
        fetch(
            "https://jsonplaceholder.typicode.com/users")
            .then((res) => res.json())
            .then((json) => {
                this.setState({
                    items: json,
                    dataIsLoaded: true
                });
            })
    }

    render() {
        const {dataIsLoaded, items} = this.state;
        if (!dataIsLoaded) {
            return (<Loader type={"pacman"} active={true}/>)
        }
        return (
            <div className="App">
                <p>
                    {
                        items.map((item) => (
                            <li className="book-element" key={item.id}>
                                Full Name: {item.name},
                            </li>
                        ))
                    }
                </p>
            </div>
        );
    }
}

export default BooksList;
