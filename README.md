### **ChatApp - Group Chat with Spring Boot & React**  

#### **Overview**  
ChatApp is a real-time group chat application built using **Spring Boot** for the backend and **React** for the frontend. It leverages **WebSocket, STOMP, and SockJS** for real-time messaging and **MongoDB** for data storage.

---

### **Tech Stack**
- **Backend**: Spring Boot, WebSocket , MongoDB
- **Frontend**: React.js
- **Database**: MongoDB
- **Protocol**: WebSocket
- **Build Tools**: Maven
- **Version Control**: Git & GitHub

---

### **Features**
✔️ Create and join chat rooms  
✔️ Real-time messaging with WebSockets  
✔️ Store chat history in MongoDB  
✔️ User-friendly React UI  
✔️ Scalable and efficient architecture  

---

### **Project Setup**

#### **1. Clone the Repository**
```sh
git clone https://github.com/yourusername/ChatApp.git
cd ChatApp
```

#### **2. Backend Setup**
1. Navigate to the backend folder:
   ```sh
   cd ChatAppBackend
   ```
2. Configure **MongoDB** in `application.properties`:
   ```properties
   spring.data.mongodb.uri=mongodb://localhost:27017/chatapp
   ```
3. Run the Spring Boot application:
   ```sh
   mvn spring-boot:run
   ```

#### **3. Frontend Setup**
1. Navigate to the frontend folder:
   ```sh
   cd ChatFrontend
   ```
2. Install dependencies:
   ```sh
   npm install
   ```
3. Start the React app:
   ```sh
   npm start
   ```

---

### **WebSocket Implementation**
- **STOMP (Simple Text Oriented Messaging Protocol)** is used for message communication.
- **SockJS** provides WebSocket fallback support.
- Spring Boot handles WebSocket connections through `@EnableWebSocketMessageBroker`.

---

### **API Endpoints**
| Method | Endpoint            | Description                 |
|--------|---------------------|-----------------------------|
| POST   | `/chat/createRoom`  | Create a new chat room      |
| GET    | `/chat/rooms`       | Get all chat rooms          |
| POST   | `/chat/sendMessage` | Send a message in a room    |
| GET    | `/chat/messages`    | Retrieve chat history       |

---

### **Contributing**
Feel free to fork this repo and submit PRs! Contributions are welcome. 🚀

---

### **License**
MIT License. 
