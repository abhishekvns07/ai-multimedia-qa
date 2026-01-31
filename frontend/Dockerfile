# Use Node
FROM node:18-alpine

# Set working directory
WORKDIR /app

# Copy dependency files
COPY package*.json ./

# Install dependencies
RUN npm install

# Copy app source
COPY . .

# Expose frontend port
EXPOSE 3000

# Start React app
CMD ["npm", "start"]
