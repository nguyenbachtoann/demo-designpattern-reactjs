import React from "react";
import { APIs } from "../../common/apis";


const axios = require("axios");

export class ProductCreateForm extends React.Component {

  constructor(props){
    super(props);
    this.state = {
      productName : ''
    };
    
  }

  handleChange = (e) => {
    this.setState({
      productName : e.target.value
    });
  };

  handleSubmit = (e) => {
    let productObject = this.state;
    axios
    .post(APIs.apiCreatProduct, productObject)
    .then(res => {
      console.log(res)
    })
    .catch(function(error) {
      console.log(error);
    })
    .finally(function() {});

    e.preventDefault();
  };


  
  render() {
    return (
      <div>
        <form onSubmit={this.handleSubmit}>
        <label>
          Product Name:
          <input type="text" value={this.state.productName} onChange={this.handleChange} />
        </label>
        <input type="submit" value="Submit" />
      </form>
      </div>
    );
  }
}
