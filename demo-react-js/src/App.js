import React from 'react';
 

const axios = require('axios');

class App extends React.Component {

  constructor(props){
    super(props); 
    this.state = {
      message: []
    }
  }


  handleOnClick=()=>{
    axios.get('http://192.168.7.21:8080/getAllProduct')
    .then(res=>{
      this.setState({
        message: res.data
      });
     
    })
    .catch(function(error){
      console.log(error);
    })
    .finally(function(){

    });
  }

 render(){
   return (
      <div>
          <button className="btn-get-all" onClick={this.handleOnClick}>
            Get All
          </button>

        <p className="show-text">
            {this.state.message.map(product=>{
              return product.productName
            })}
        </p>

      </div>
   );
 }
}

export default App;
