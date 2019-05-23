import React from "react";
import { ProductCreateForm } from "./container/components/ProductCreatForm";
import { APIs } from "./common/apis";


const axios = require("axios");

class App extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      message: []
    };
  }

  handleOnClick = () => {
    axios
      .get(APIs.apiGetAllProduct)
      .then(res => {
        this.setState({
          message: res.data
        });
      })
      .catch(function(error) {
        console.log(error);
      })
      .finally(function() {});
  };

  render() {
    return (
      <div>
        <button className="btn-get-all" onClick={this.handleOnClick}>
          Get All
        </button>

        <p className="show-text">
          {this.state.message.map(product => {
            return product.productName;
          })}
        </p>
        <ProductCreateForm />
      </div>
    );
  }
}

export default App;
