import SwiftUI
import shared
struct ClassListComponent: View {
    let classes: [RoaryRepoInfo]
    let isHomePage: Bool
    @ObservedObject var viewModel: iOSRoaryViewModel

    var body: some View {
        ScrollView {
//            LazyVStack {
//                ForEach(classes, id: \.className) { classItem in
//                    let isHomePage = Bool.random()//random for now...
//                    if isHomePage {
//                        NavigationLink(destination: NotificationListView(notifications:Test().test2)) {
//                            ClassComponent(
//                                classTitle: classItem.className,
//                                classDescription: classItem.classDescription,
//                                classImage: Image("sample"),
//                                isHomePage: isHomePage
//                            )
//                            .padding(.vertical, 10)
//                        }
//                    } else {
//                        NavigationLink(destination: ClassDetailsView(classItem: classItem)) {
//                            ClassComponent(
//                                classTitle: classItem.className,
//                                classDescription: classItem.classDescription,
//                                classImage: Image("sample"),
//                                isHomePage: isHomePage
//                            )
//                            .padding(.vertical, 10)
//                        }
//                    }
//                }
//            }
            LazyVStack {
                ForEach(classes, id: \.className) { classItem in
                    let isHomePage = Bool.random() //random for now...

                    Group {
                        var assignments = convertToList(classItem.classAssignments)

                        if isHomePage {
                            NavigationLink(destination: NotificationListView(assignments: assignments,course: classItem,viewModel: viewModel)) {
                                ClassComponent(
                                    classTitle: classItem.className,
                                    classDescription: classItem.classDescription,
                                    classImage: Image("sample"),
                                    isHomePage: isHomePage
                                )
                                .padding(.vertical, 10)
                            }
                        }
 else {
                            NavigationLink(destination: ClassDetailsView(classItem: classItem)) {
                                ClassComponent(
                                    classTitle: classItem.className,
                                    classDescription: classItem.classDescription,
                                    classImage: Image("sample"),
                                    isHomePage: isHomePage
                                )
                                .padding(.vertical, 10)
                            }
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
//            RoaryRepoInfo(className: "History 101", classDescription: "Learn about ancient civilizations and their impact on modern society.", classAssignments: []),
//            RoaryRepoInfo(className: "Math 202", classDescription: "Advanced calculus and mathematical analysis.", classAssignments: [])
            RoaryRepoInfo()
        ]

        NavigationView {
            ClassListComponent(classes: classes, isHomePage: true,viewModel: iOSRoaryViewModel(repository: RoaryViewModel()))
        }
    }
}
