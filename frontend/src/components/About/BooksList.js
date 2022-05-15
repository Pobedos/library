import React from "react";

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
            "/api/books")
            .then((res) => res.json())
            .then((json) => {
                this.setState({
                    items: json,
                    dataIsLoaded: true
                });
                console.log(json)
            })
            .catch((e) => console.log(e));
    }

    render() {
        const {items} = this.state;
        return (
            <div className="App">
                <ul>
                    {
                        items.map((item) => (
                            <li className="book-element" key={item.id}>
                                {item.name},
                            </li>
                        ))
                    }
                </ul>
            </div>
        );
    }
}

export default BooksList;
