//
//  NotificationListView.swift
//  RoaryMinder
//
//  Created by Zacharias Lafond on 3/7/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared
struct NotificationListView: View {
    @State var assignments: [Assignments]
    @State var course: RoaryRepoInfo
    @ObservedObject var viewModel: iOSRoaryViewModel
    var body: some View {
        ScrollView {
            VStack(spacing: 20) {
                ForEach(assignments) { assignment in
                    NavigationLink(destination: ChatView(chatRepo:assignment.chatRepo ?? ChatRepos(),assignment: assignment,viewModel: viewModel)) {
                        NotificationView(assignment: assignment) {
                            // Bell button action here
                            print("Bell button tapped")
                        }
                    }
                }
                
                NavigationLink(destination: AddNotificationView(assignments: $assignments,course: course,viewModel: viewModel)) {
                    Text("+ Add New Reminder")
                        .font(.headline)
                        .foregroundColor(.blue)
                        .padding()
                        .background(Color(UIColor.systemBackground))
                        .cornerRadius(10)
                        .shadow(color: Color.gray.opacity(0.3), radius: 2, x: 0, y: 2)
                }
            }
            .padding(.vertical, 20)
        }
    }
}

struct NotificationListView_Previews: PreviewProvider {
    static var previews: some View {
        let messages = ["Hello!", "How are you?"]
        let messagesArray = NSMutableArray(array: messages)
        let chatRepo = ChatRepos()
        let assignments = [
            Assignments()
        ]

        NotificationListView(assignments: assignments,course: RoaryRepoInfo(), viewModel: iOSRoaryViewModel(repository: RoaryViewModel()))
    }
}
