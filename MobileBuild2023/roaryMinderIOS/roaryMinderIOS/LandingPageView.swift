//
//  LandingPageView.swift
//  RoaryMinder
//
//  Created by Uriel Juarez on 2/25/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared
struct ViewOffsetKey: PreferenceKey {
        static var defaultValue: CGFloat = 0
        static func reduce(value: inout CGFloat, nextValue: () -> CGFloat) {
        value = nextValue()
    }
}
struct LandingPageView: View {
    @State private var searchText = ""
    @State private var isHomePage = false
    @State private var showSideBar = false
    @ObservedObject var viewModel: iOSRoaryViewModel

    var body: some View {
        NavigationView{
            ZStack {
                ScrollView {
                    VStack(spacing: 0) {
                        HStack {
                            Text(isHomePage ? "My Classes" : "All Classes")
                                .font(.title)
                                .fontWeight(.bold)
                            
                            Spacer()
                            
                            Button(action: {
                                showSideBar.toggle()
                            }) {
                                Image(systemName: "line.horizontal.3")
                                    .font(.title)
                            }
                            .padding(.trailing, 8)
                        }
                        .padding([.leading, .bottom, .trailing])
                        .padding(.top, 16)
                        
                        SearchBarView(text: $searchText)
                            .padding(.horizontal)
                            .padding(.bottom, 8)
                        
                        ClassListComponent(classes: viewModel.classes.filter { classItem in
                            searchText.isEmpty || classItem.className.localizedCaseInsensitiveContains(searchText)
                        }, isHomePage: isHomePage,viewModel: viewModel)

                        //Class Creation View Page
                        NavigationLink(destination: ClassCreationView(viewModel: viewModel)) {
                                                   HStack {
                                                       Image(systemName: "plus.circle.fill")
                                                           .foregroundColor(.blue)
                                                           .imageScale(.large)
                                                       Text("Add new class")
                                                   }
                                               }
                                               .padding()
                        
                    }
                    //
                    
                    .background(GeometryReader { geo in
                        Color.clear.preference(key: ViewOffsetKey.self, value: geo.frame(in: .global).minY)
                    })
                    .onPreferenceChange(ViewOffsetKey.self) { yOffset in
                        if yOffset < -100 {
                            withAnimation {
                                isHomePage = false
                            }
                        } else {
                            withAnimation {
                                isHomePage = true
                            }
                        }
                    }
                }
                
                GeometryReader { geometry in
                    SideMenuView(isHomePage: $isHomePage, showSideBar: $showSideBar)
                        .frame(width: geometry.size.width / 2)
                        .offset(x: showSideBar ? 0 : -geometry.size.width)
                        .animation(.easeInOut(duration: 0.4), value: showSideBar)
                        .gesture(DragGesture()
                            .onChanged({ value in
                                if value.translation.width < 0 {
                                    showSideBar = false
                                }
                            })
                        )
                }
                .background(Color.black.opacity(showSideBar ? 0.5 : 0))
                .ignoresSafeArea()
            }
        }

        }
    }






struct LandingPageView_Previews: PreviewProvider {
    static var previews: some View {
        LandingPageView(viewModel: iOSRoaryViewModel(repository: RoaryViewModel()))
    }
}
