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
                    ClassComponent(
                        classTitle: classItem.title,
                        classDescription: classItem.description,
                        classImage: Image("sample"),
                        isHomePage: classItem.isHomePage
                    )
                    .padding(.vertical, 10)
                }
            }
            .padding(.horizontal, 16)
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
        
        ClassListComponent(classes: classes,isHomePage: true)
            .previewLayout(.sizeThatFits)
            .padding()
    }
}
