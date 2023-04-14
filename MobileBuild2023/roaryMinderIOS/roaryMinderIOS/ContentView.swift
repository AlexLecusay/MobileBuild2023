import SwiftUI
import shared

struct ContentView: View {
//	let greet = Greeting().greet()
    @StateObject private var viewModel = iOSRoaryViewModel(repository: RoaryViewModel())

	var body: some View {
        LandingPageView(viewModel:viewModel)
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
