import SwiftUI

struct ClassListComponent: View {
    let classes: [Class]
    let isHomePage: Bool

    var body: some View {
        ScrollView {
            LazyVStack {
                ForEach(classes.filter { classItem in
                    isHomePage ? classItem.isHomePage : true
                }, id: \.title) { classItem in
                    if isHomePage {
                        NavigationLink(destination: NotificationListView(notifications:Test().test2)) {
                            ClassComponent(
                                classTitle: classItem.title,
                                classDescription: classItem.description,
                                classImage: Image("sample"),
                                isHomePage: classItem.isHomePage
                            )
                            .padding(.vertical, 10)
                        }
                    } else {
                        NavigationLink(destination: ClassDetailsView(classItem: classItem)) {
                            ClassComponent(
                                classTitle: classItem.title,
                                classDescription: classItem.description,
                                classImage: Image("sample"),
                                isHomePage: classItem.isHomePage
                            )
                            .padding(.vertical, 10)
                        }
                    }
                }
            }
            .padding(.horizontal, 16)
//            HStack {
//                Button(action: {
//                    // Perform action when button is tapped
//                }, label: {
//                    HStack {
//                        Image(systemName: "plus")
//                            .padding(.trailing, 5)
//                        Text("Add")
//                            .fontWeight(.bold)
//                    }
//                    .padding(.horizontal, 145)
//                    .padding(.vertical, 10)
//                    .background(Color.blue)
//                    .foregroundColor(.white)
//                    .cornerRadius(8)
//                    .overlay(
//                        RoundedRectangle(cornerRadius: 8)
//                            .stroke(Color.blue, lineWidth: 2)
//                    )
//                })
//            }
            Spacer()
        }
    }
}


struct ClassListComponent_Previews: PreviewProvider {
    static var previews: some View {
        let classes = [
            Class(title: "History 101", description: "Learn about ancient civilizations and their impact on modern society.", isHomePage: true),
            Class(title: "Math 202", description: "Advanced calculus and mathematical analysis.", isHomePage: false),
            Class(title: "Chemistry 101", description: "Introduction to chemical reactions and bonding.", isHomePage: false),
            Class(title: "English 201", description: "Analyzing literature and critical thinking.", isHomePage: false),
            Class(title: "Biology 101", description: "Fundamentals of biology and evolution.", isHomePage: false),
            Class(title: "Art 101", description: "Introduction to painting and drawing techniques.", isHomePage: true),
            Class(title: "Computer Science 101", description: "Programming basics and problem solving.", isHomePage: true),
            Class(title: "Music 101", description: "Fundamentals of music theory and composition.", isHomePage: true)
        ]

        NavigationView {
            ClassListComponent(classes: classes, isHomePage: true)
        }
    }
}
