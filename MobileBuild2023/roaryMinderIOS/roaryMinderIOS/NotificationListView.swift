//
//  NotificationListView.swift
//  RoaryMinder
//
//  Created by Zacharias Lafond on 3/7/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI

struct NotificationListView: View {
    var notifications: [Assignment]
    
    var body: some View {
            ScrollView {
                VStack(spacing: 20) {
                    ForEach(notifications) { notification in
                        NavigationLink(destination: ChatView(notification: notification)) {
                            NotificationView(title: notification.title, date: notification.date) {
                                // Bell button action here
                                print("Bell button tapped")
                            }
                        }
                    }
                    
                    NavigationLink(destination: AddNotificationView()) {
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
        let chatRepo = ChatRepo(messages: messages)

        let assignments = [
            Assignment(title: "Homework Assignment", description: "Complete exercises 1-5", date: Date(), course: "Mathematics", chats: chatRepo),
            Assignment(title: "Lab Report", description: "Write a report on the experiment", date: Date(), course: "Chemistry", chats: chatRepo),
            Assignment(title: "Essay", description: "Write a 3-page essay on the topic", date: Date(), course: "English", chats: chatRepo)
        ]

        NotificationListView(notifications: assignments)
    }
}
