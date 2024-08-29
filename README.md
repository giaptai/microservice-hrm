<h2>Standard Kafka</h2>
<h4>Consumer and producer</h4>
<img src="https://github.com/giaptai/microservice-hrm/assets/102518847/0244ae9e-46e4-46d9-9f31-0f7babbfbe47">
<h4>Producer and Connect - Sink</h4>
<p>Module hoso_chitiet - a Producer will send data with schema and payload structure to Kafka server which will be consume by Sink for store in MySQL</p>
<img src="https://github.com/giaptai/microservice-hrm/assets/102518847/e9f25c37-2717-4325-82b7-8962a2ab7f4e">
<h4>Connect - Source and Sink</h4>
<p>Module taikhoan - Source will get the newest data updated, send to Kafka server, then Another Module - has Kafka Streams will get and modify data to get another module</p>
<img src="https://github.com/giaptai/microservice-hrm/assets/102518847/9ddec5f2-d101-4017-b4db-b53be2582225">

