# Movie App with Jetpack Compose

This project demonstrates a scalable movie app using **Jetpack Compose**, **Clean Architecture**, and **Dependency Injection**. It’s designed to showcase best practices in modern Android development with an emphasis on clean code, modularity, and testability.

## Features

- **Jetpack Compose** for a modern UI experience.
- **Clean Architecture + MVVM** for modular and maintainable code.
- **Retrofit** for network operations.
- **Dependency Injection** using Custom Injection.
- **Coroutines and Flow** for asynchronous data handling.
- **LiveData** for UI updates.

## Tech Stack

- **Kotlin**: Programming language.
- **Jetpack Compose**: UI Toolkit.
- **Retrofit**: HTTP Client.
- **Coroutines**: Asynchronous programming.
- **Flow**: Asynchronous data streams.
- **LiveData**: Observable data holder.

## Getting Started

### Prerequisites

- Android Studio Chipmunk or later.
- Kotlin 1.7 or later.

### Installation

1. Clone the repository:

    ```bash
    git clone https://github.com/aamaulana10/movie-compose.git
    ```

2. Open the project in Android Studio.

3. Build the project and run it on an Android emulator or device.

## Project Structure

- **domain**: Contains use cases and entity models.
- **data**: Handles data sources, repositories, and API interactions.
- **presentation**: UI components, including Compose screens and ViewModels.

## API Setup

- The app fetches movie data using the Movie DB API. Make sure to configure your API settings in the `Retrofit` service class.

## How to Use

- Explore various movie listings.
- View movie details with information fetched dynamically.
- Easy navigation using Compose components.

## Contributing

Contributions are welcome! Please open an issue or submit a pull request for any improvements or bug fixes.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Contact

Feel free to reach out via LinkedIn or create an issue in this repository for any queries.

Happy Coding! 🚀
